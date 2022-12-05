package com.composebottomsheet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composebottomsheet.ui.theme.ComposeBottomSheetTheme
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBottomSheetTheme {
                val sheetState = rememberBottomSheetState(
                    initialValue = BottomSheetValue.Collapsed,
//                    animationSpec = spring(
//                        dampingRatio = Spring.DampingRatioHighBouncy
//                    )
                )
                val scaffoldState = rememberBottomSheetScaffoldState(
                    bottomSheetState = sheetState
                )
                val scope = rememberCoroutineScope()
                BottomSheetScaffold(
                    scaffoldState = scaffoldState,
                    sheetContent = {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .padding(horizontal = 16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Bottom sheet",
                                fontSize = 52.sp
                            )
                        }
                    },
                    sheetBackgroundColor = Color.Green,
                    //Sheet is hidden by default
//                    sheetPeekHeight = 0.dp
                ) {
                    Box(modifier = Modifier
                        .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(onClick = {
                            scope.launch {
                                if (sheetState.isCollapsed) {
                                    sheetState.expand()
                                } else {
                                    sheetState.collapse()
                                }
                            }
                        }
                        ) {
                            Text(text = "Toggle sheet fraction: ${sheetState.progress.fraction}")
                        }
                    }
                }
            }
        }
    }
}