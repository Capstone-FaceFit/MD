package com.app.facefit.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.facefit.R
import com.app.facefit.ui.theme.interFontFamily

@Composable
fun FeatureBanner(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(170.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF1FCA3E),
                        Color(0xFF00BBC3),
                    )
                )
            )
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = "Pindai Wajahmu dan dapatkan Kacamata Impianmu",
            fontFamily = interFontFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(15.dp))
        Image(
            painter = painterResource(id = R.drawable.baseline_sensor_occupied_24),
            contentDescription = "scan_banner",
            modifier = Modifier.size(65.dp)
        )
    }
}