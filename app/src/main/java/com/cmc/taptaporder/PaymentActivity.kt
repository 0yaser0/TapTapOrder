package com.cmc.taptaporder

import android.content.Intent
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.os.Environment
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import java.io.File
import java.io.FileOutputStream

class PaymentActivity : AppCompatActivity() {

    private lateinit var totalPriceTextView: TextView
    private lateinit var cartItems: ArrayList<PaymentItem>
    private lateinit var adapter: PaymentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_payment)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val recyclerView: RecyclerView = findViewById(R.id.payment_recycler_view)
        totalPriceTextView = findViewById(R.id.total_price)
        val getTicketButton: MaterialButton = findViewById(R.id.get_ticket_button)
        val back :ImageView = findViewById(R.id.back)

        back.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        cartItems = intent.getParcelableArrayListExtra("cartItems") ?: arrayListOf()
        updateTotalPrice()

        adapter = PaymentAdapter(cartItems) { updatedItem ->
            updateTotalPrice()
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        getTicketButton.setOnClickListener {
            generateTicket()
        }
    }

    private fun updateTotalPrice() {
        val totalPrice = cartItems.sumOf { it.price * it.quantity }
        totalPriceTextView.text = "$totalPrice DH"
    }


    private fun generateTicket() {
        val pdfDocument = PdfDocument()
        val pageInfo = PdfDocument.PageInfo.Builder(300, 600, 1).create()
        val page = pdfDocument.startPage(pageInfo)
        val canvas = page.canvas
        val paint = Paint()
        paint.textSize = 12f
        paint.isAntiAlias = true

        var yPosition = 20
        canvas.drawText("TICKET", 10f, yPosition.toFloat(), paint)
        yPosition += 20
        canvas.drawText("--------", 10f, yPosition.toFloat(), paint)
        yPosition += 20

        cartItems.forEach { item ->
            val itemLine = "${item.title} x${item.quantity} - ${item.price * item.quantity} DH"
            canvas.drawText(itemLine, 10f, yPosition.toFloat(), paint)
            yPosition += 20
        }

        yPosition += 10
        canvas.drawText("--------", 10f, yPosition.toFloat(), paint)
        yPosition += 20
        val total = "Total: ${cartItems.sumOf { it.price * it.quantity }} DH"
        canvas.drawText(total, 10f, yPosition.toFloat(), paint)
        pdfDocument.finishPage(page)
        val filePath = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "Ticket.pdf")
        try {
            pdfDocument.writeTo(FileOutputStream(filePath))
            Toast.makeText(this, "Ticket saved to ${filePath.absolutePath}", Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Error saving ticket: ${e.message}", Toast.LENGTH_LONG).show()
        } finally {
            pdfDocument.close()
        }
    }
}
