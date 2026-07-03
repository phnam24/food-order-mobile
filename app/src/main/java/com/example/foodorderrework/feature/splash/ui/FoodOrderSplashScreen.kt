package com.example.foodorderrework.feature.splash.ui
import android.annotation.SuppressLint
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodorderrework.ui.theme.AppColor
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

val AmbientBgColors = listOf(
    AppColor.PrimaryContainer.copy(alpha = 0.6f),
    AppColor.Background,
    AppColor.Surface,
    AppColor.PrimaryContainer.copy(alpha = 0.4f)
)

@Composable
fun FoodOrderSplashRoute(
    onLoginNavigate: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(5_000L.milliseconds)
        onLoginNavigate()
    }

    FoodOrderSplashScreen()
}

@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun FoodOrderSplashScreen() {
    val infiniteTransition = rememberInfiniteTransition(label = "infinite_transition")

    // 1. Animation cho nền Gradient trôi từ từ
    val bgOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(15000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "bg_gradient_anim"
    )

    val bgBrush = Brush.linearGradient(
        colors = AmbientBgColors,
        start = Offset(bgOffset, bgOffset),
        end = Offset(bgOffset + 1500f, bgOffset + 1500f)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bgBrush)
    ) {
        // 2. Các icon trang trí trôi nổi ở background
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val w = maxWidth
            val h = maxHeight

            FloatingIcon(Icons.Rounded.LocalPizza, x = w * 0.1f, y = h * 0.15f, delay = 0, size = 36.dp)
            FloatingIcon(Icons.Rounded.LunchDining, x = w * 0.85f, y = h * 0.2f, delay = 1500, size = 32.dp)
            FloatingIcon(Icons.Rounded.Icecream, x = w * 0.2f, y = h * 0.75f, delay = 3000, size = 48.dp)
            FloatingIcon(Icons.Rounded.BakeryDining, x = w * 0.9f, y = h * 0.85f, delay = 4500, size = 36.dp)
            FloatingIcon(Icons.Rounded.Coffee, x = w * 0.95f, y = h * 0.4f, delay = 2000, size = 24.dp)
            FloatingIcon(Icons.Rounded.RamenDining, x = w * 0.05f, y = h * 0.55f, delay = 500, size = 32.dp)
        }

        // 3. Nội dung chính ở giữa
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(24.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Animated Logo (Bounce & Glow)
            val bounceOffset by infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = (-15f),
                animationSpec = infiniteRepeatable(
                    animation = tween(800, easing = FastOutSlowInEasing),
                    repeatMode = RepeatMode.Reverse
                ),
                label = "bounce_anim"
            )

            Box(
                modifier = Modifier
                    .offset(y = bounceOffset.dp)
                    .size(128.dp)
                    .shadow(elevation = 20.dp, shape = CircleShape, spotColor = AppColor.Primary)
                    .background(AppColor.Primary, CircleShape), // Sử dụng màu Primary
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Rounded.Restaurant,
                    contentDescription = "Logo",
                    tint = AppColor.OnPrimary, // Sử dụng màu OnPrimary (Trắng)
                    modifier = Modifier.size(64.dp)
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Tên Brand & Slogan
            Text(
                text = "FOOD ORDER",
                fontSize = 42.sp,
                fontWeight = FontWeight.ExtraBold,
                color = AppColor.TextPrimary, // Chữ tiêu đề chính
                letterSpacing = (-1).sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Giao tận tay, ngon mê say",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = AppColor.Success, // Dùng màu Success (xanh đậm hơn) để dễ đọc trên nền sáng
                letterSpacing = 0.5.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Shimmer Loading (Tiến trình)
            ShimmerProgressBar()

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "ĐANG TẢI...",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = AppColor.TextSecondary.copy(alpha = 0.6f), // Chữ phụ làm mờ nhẹ
                letterSpacing = 2.sp
            )
        }
    }
}

// --- COMPONENT: Icon trôi nổi ---
@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun FloatingIcon(icon: ImageVector, x: Dp, y: Dp, delay: Int, size: Dp) {
    val transition = rememberInfiniteTransition(label = "float")
    val translationY by transition.animateFloat(
        initialValue = 0f,
        targetValue = -20f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, delayMillis = delay, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "float_y"
    )
    val rotation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 10f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, delayMillis = delay, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "float_rotate"
    )

    Icon(
        imageVector = icon,
        contentDescription = null,
        tint = AppColor.TextPrimary.copy(alpha = 0.1f), // Màu icon chìm vào nền
        modifier = Modifier
            .offset(x = x, y = y + translationY.dp)
            .rotate(rotation)
            .size(size)
    )
}

// --- COMPONENT: Thanh Shimmer Line ---
@Composable
fun ShimmerProgressBar() {
    val transition = rememberInfiniteTransition(label = "shimmer")
    val translateAnim by transition.animateFloat(
        initialValue = -300f,
        targetValue = 600f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "shimmer_anim"
    )

    val shimmerBrush = Brush.linearGradient(
        colors = listOf(
            Color.Transparent,
            AppColor.Primary.copy(alpha = 0.5f), // Vùng sáng lướt qua
            Color.Transparent
        ),
        start = Offset(translateAnim, 0f),
        end = Offset(translateAnim + 300f, 0f)
    )

    Box(
        modifier = Modifier
            .width(200.dp)
            .height(4.dp)
            .clip(RoundedCornerShape(50))
            .background(AppColor.Primary.copy(alpha = 0.15f)) // Nền của thanh loading
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(shimmerBrush)
        )
    }
}