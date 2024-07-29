package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                    ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(
            top = 120.dp,
        )
    ) {
        CardHeader(
            name = stringResource(R.string.business_card_name),
            title = stringResource(R.string.business_card_position)
        )
        CardInfo(
            phoneNumber = stringResource(R.string.card_info_phone),
            email = stringResource(R.string.card_info_email),
            city = stringResource(R.string.card_info_location)
        )
    }
}

@Composable
fun CardHeader(name: String, title: String) {
    val logo = painterResource(R.drawable.logo_placeholder_png_2)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = logo,
            contentDescription = stringResource(R.string.brand_logo)
        )
        Text(
            text = name,
            color = MaterialTheme.colorScheme.primary,
            fontSize = 42.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.SansSerif,
            letterSpacing = 4.sp,
        )
        Text(
            text = title,
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.inversePrimary,
            fontWeight = FontWeight.Light,
            fontFamily = FontFamily.SansSerif,
            letterSpacing = 4.sp,
        )
    }
}

@Composable
fun CardInfo(phoneNumber: String, email: String, city: String) {
    Column (
        modifier = Modifier.padding(
            start = 16.dp,
            top = 180.dp,
            bottom = 16.dp,
            end = 16.dp
        ),
    ) {
        Row {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = stringResource(R.string.email_icon_description),
                modifier = Modifier.padding(end = 12.dp)
            )
            Text(
                text = email,
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                color = MaterialTheme.colorScheme.secondary
            )
        }
        Spacer(modifier = Modifier.padding(bottom = 4.dp))
        Row {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = stringResource(R.string.phone_icon_description),
                modifier = Modifier.padding(end = 12.dp)
            )
            Text(
                text = phoneNumber,
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                color = MaterialTheme.colorScheme.secondary
            )
        }
        Spacer(modifier = Modifier.padding(bottom = 4.dp))
        Row {
            Icon(
                imageVector = Icons.Default.Place,
                contentDescription = stringResource(R.string.location_icon_description),
                modifier = Modifier.padding(end = 12.dp)
            )
            Text(
                text = city,
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            BusinessCard()
        }
    }
}
