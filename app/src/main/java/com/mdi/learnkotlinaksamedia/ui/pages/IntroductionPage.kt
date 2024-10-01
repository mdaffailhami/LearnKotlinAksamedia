package com.mdi.learnkotlinaksamedia.ui.pages

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mdi.learnkotlinaksamedia.R
import com.mdi.learnkotlinaksamedia.models.Introduction
import com.mdi.learnkotlinaksamedia.ui.components.SlideIndicator
import kotlinx.coroutines.launch

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun UIPreview() = IntroductionPage()

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IntroductionPage() {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState() { 3 }

    val introductions = listOf(
        Introduction(
            image = R.drawable.slide1,
            title = "Gratis Materi Belajar\nMenjadi Seller Handal",
            description = "Nggak bisa jualan?\nJangan khawatir, Tokorame akan membimbing kamu hingga menjadi seller langsung dari ahlinya"
        ),
        Introduction(
            image = R.drawable.slide2,
            title = "Ribuan Produk\ndengan Kualitas Terbaik",
            description = "Tokorame menyediakan ribuan produk dengan kualitas derbaik dari seller terpercaya"
        ),
        Introduction(
            image = R.drawable.slide3,
            title = "Toko Online Unik\nUntuk Kamu Jualan",
            description = "Subdomain unik dan toko online profesional siap pakai"
        )

    )

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 0.dp,
                    bottom = 0.dp,
                    start = innerPadding.calculateLeftPadding(LayoutDirection.Ltr),
                    end = innerPadding.calculateRightPadding(LayoutDirection.Rtl)
                )
        ) {
            Box(modifier = Modifier.fillMaxHeight(7f / 10f)) {
                HorizontalPager(
                    state = pagerState,
                ) { page ->
                    Image(
                        painter = painterResource(id = introductions[page].image),
                        contentDescription = "1st Slide",
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier.fillMaxHeight()
                    )
                }
                Text(
                    "Lewati",
                    fontWeight = FontWeight.W500,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    color = Color(0xFF434747),
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset((-20).dp, 50.dp),
                )
                SlideIndicator(
                    pagerState = pagerState,
                    onClick = { index: Int ->
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .offset(y = (-55).dp)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(Color.White)
                    .fillMaxWidth()
                    .fillMaxHeight(3.3f / 10f)
                    .align(Alignment.BottomCenter)
                    .padding(top = 34.dp, start = 18.dp, end = 18.dp)
            ) {
                Text(
                    introductions[pagerState.currentPage].title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W700,
                    lineHeight = 32.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF242626),
                )
                Spacer(Modifier.height(18.dp))
                Text(
                    introductions[pagerState.currentPage].description,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    lineHeight = 16.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF242626),
                )
                Spacer(Modifier.weight(1f))
                ElevatedButton(
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    },
                    colors = ButtonColors(
                        containerColor = Color(0xFF242626),
                        contentColor = Color(0xFFF5F6F6),
                        disabledContainerColor = Color(0xFF242626),
                        disabledContentColor = Color(0xFFF5F6F6)
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        "Selanjutnya",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W500,
                        lineHeight = 16.sp,
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(Modifier.height(53.dp))
            }
        }
    }
}