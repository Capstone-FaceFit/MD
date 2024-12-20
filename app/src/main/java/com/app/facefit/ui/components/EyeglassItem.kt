package com.app.facefit.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.facefit.R
import com.app.facefit.helper.formatPrice
import com.app.facefit.ui.theme.interFontFamily

@Composable
fun EyeglassItem(
    name: String,
    price: String,
    image: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .padding(
                    top = 15.dp,
                    start = 8.dp,
                    end = 8.dp,
                    bottom = 20.dp
                )
        ) {
            AsyncImage(
                model = image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            ) {
                Text(
                    text = name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 11.sp
                )
                Text(
                    text = stringResource(id = R.string.price_tag, formatPrice(price)),
                    fontFamily = interFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 18.sp
                )
            }
        }
    }
}