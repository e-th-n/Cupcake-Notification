package receiver

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import com.example.cupcake.sendNotification

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent){
        val notificationManager = ContextCompat.getSystemService(
                context,
                NotificationManager::class.java
        )

        notificationManager?.sendNotification(
                "iIn the mood for a cupcake?",
                context
        )
    }
}