package com.example.wazitoecommerce.ui.theme.screens.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wazitoecommerce.R
import com.example.wazitoecommerce.navigation.ADD_PRODUCTS_URL
import com.example.wazitoecommerce.ui.theme.Orange
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme
import com.example.wazitoecommerce.ui.theme.screens.home.bottomNavItems

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Orange),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var selected by remember { mutableIntStateOf(1) }
        Scaffold(
            bottomBar = {
                NavigationBar {
                    bottomNavItems.forEachIndexed { index, bottomNavItem ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = {
                                selected = index
                                navController.navigate(bottomNavItem.route)
                            },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (bottomNavItem.badges != 0) {
                                            Badge {
                                                Text(text = bottomNavItem.badges.toString())
                                            }
                                        } else if (bottomNavItem.hasNews) {
                                            Badge()
                                        }
                                    }
                                ) {
                                    Icon(
                                        imageVector = if (index == selected)
                                            bottomNavItem.selectedIcon
                                        else
                                            bottomNavItem.unselectedIcon,
                                        contentDescription = bottomNavItem.title
                                    )
                                }
                            },
                            label = {
                                Text(text = bottomNavItem.title)
                            }
                        )
                    }
                }
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "CaRS",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 50.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                    // Add your profile content here
                    Spacer(modifier = Modifier.height(15.dp))
                    Row {
                        //start of card
                        Card(
                            modifier = Modifier
                                .height(300.dp)
                                .width(400.dp),
                        ) {
                            //Column {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(300.dp).clickable { navController.navigate(
                                        ADD_PRODUCTS_URL) },
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.cars),
                                    contentDescription = "new",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                                Text(
                                    text = "Add Cars",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 30.sp,
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    color = Orange
                                )
                            }

                            // }

                        }
                        //End of card
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row {
                        //start of card
                        Card(
                            modifier = Modifier
                                .height(300.dp)
                                .width(400.dp),
                        ) {
                            //Column {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(300.dp).clickable { },
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.bg),
                                    contentDescription = "new",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                                Text(
                                    text = "Upload Cars",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 30.sp,
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    color = Orange
                                )
                            }

                            // }

                        }
                        //End of card
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                }
            }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ProfileScreenPreview() {
    WazitoECommerceTheme {
        ProfileScreen(navController = rememberNavController())
    }
}
