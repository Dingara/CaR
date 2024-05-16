package com.example.wazitoecommerce.ui.theme.screens.home

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
import com.example.wazitoecommerce.navigation.ADD_RENTAL_URL
import com.example.wazitoecommerce.navigation.HOME_URL
import com.example.wazitoecommerce.navigation.LOGIN_URL
import com.example.wazitoecommerce.ui.theme.Orange
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController:NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var selected by remember { mutableIntStateOf(0) }
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
                                    Icon(imageVector =
                                    if (index == selected)
                                        bottomNavItem.selectedIcon
                                    else
                                        bottomNavItem.unselectedIcon,
                                        contentDescription = bottomNavItem.title)
                                }

                            },
                            label = {
                                Text(text = bottomNavItem.title)
                            })
                    }
                }
            },


            floatingActionButton = {
                FloatingActionButton(onClick = { navController.navigate(ADD_PRODUCTS_URL) }) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Add,
                            contentDescription = "menu")
                    }
                }
            },
            //Content Section
            content = @Composable {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    Spacer(modifier = Modifier.height(5.dp))




                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Row {
                            Button(
                                onClick = {
                                    navController.navigate(HOME_URL)
                                },
                                shape = RoundedCornerShape(5.dp),
                                colors = ButtonDefaults.buttonColors(Color.Blue),
                                modifier = Modifier
                                    .padding(start = 50.dp)
                            )
                            {
                                Text(text = "Home")

                            }
                            Button(
                                onClick = { /*TODO*/ },
                                shape = RoundedCornerShape(5.dp),
                                colors = ButtonDefaults.buttonColors(Color.Blue),
                                modifier = Modifier
                                    .padding(start = 20.dp)
                            )
                            {
                                Text(text = "About us")

                            }


                        }

                        Image(
                            painter = painterResource(id = R.drawable.car),
                            contentDescription = "car",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = "All cars",
                            fontSize = 35.sp,
                            color = Color.Green,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center
                        )

                    }
                    Column(modifier = Modifier.padding(start = 10.dp)) {

                        Spacer(modifier = Modifier.height(5.dp))

                        Row {
                            Card(
                                modifier = Modifier
                                    .height(190.dp)
                                    .width(180.dp)
                            )
                            {
                                Column {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(105.dp),
                                        contentAlignment = Alignment.Center
                                    )
                                    {
                                        Image(
                                            painter = painterResource(id = R.drawable.rav4),
                                            contentDescription = "galaxy",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Text(
                                        text = "Toyota land cruiser prado",
                                        fontSize = 12.sp,
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                    Text(
                                        text = "5 seats 5 doors petrol",
                                        fontSize = 10.sp,
                                        color = Color.DarkGray,
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                    Text(
                                        text = "ksh 3000",
                                        fontSize = 8.sp,
                                        color = Color.DarkGray,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )

                                    Button(onClick = { navController.navigate(ADD_RENTAL_URL) }) {
                                        Text(text = "Rent now")

                                    }
                                }

                            }
                            Spacer(modifier = Modifier.width(20.dp))

                            Card(
                                modifier = Modifier
                                    .height(190.dp)
                                    .width(180.dp)
                            )
                            {
                                Column {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(105.dp),
                                        contentAlignment = Alignment.Center
                                    )
                                    {
                                        Image(
                                            painter = painterResource(id = R.drawable.bg),
                                            contentDescription = "galaxy",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Text(
                                        text = "GT Mustang ",
                                        fontSize = 12.sp,
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                    Text(
                                        text = "5 seats 5 doors petrol",
                                        fontSize = 10.sp,
                                        color = Color.DarkGray,
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                    Text(
                                        text = "ksh 15000",
                                        fontSize = 8.sp,
                                        color = Color.DarkGray,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                    Button(onClick = { navController.navigate(ADD_RENTAL_URL) }) {
                                        Text(text = "Rent now")

                                    }
                                }
                            }

                        }
                        Spacer(modifier = Modifier.height(10.dp))


                        Row {
                            Card(
                                modifier = Modifier
                                    .height(190.dp)
                                    .width(180.dp)
                            )
                            {
                                Column {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(105.dp),
                                        contentAlignment = Alignment.Center
                                    )
                                    {
                                        Image(
                                            painter = painterResource(id = R.drawable.toyalphard),
                                            contentDescription = "galaxy",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Text(
                                        text = "Toyota Alphard",
                                        fontSize = 12.sp,
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                    Text(
                                        text = "5 seats 5 doors petrol",
                                        fontSize = 10.sp,
                                        color = Color.DarkGray,
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                    Text(
                                        text = "ksh 8000",
                                        fontSize = 8.sp,
                                        color = Color.DarkGray,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )

                                    Button(onClick = { navController.navigate(ADD_RENTAL_URL) }) {
                                        Text(text = "Rent now")

                                    }
                                }

                            }
                            Spacer(modifier = Modifier.width(20.dp))

                            Card(
                                modifier = Modifier
                                    .height(190.dp)
                                    .width(180.dp)
                            )
                            {
                                Column {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(105.dp),
                                        contentAlignment = Alignment.Center
                                    )
                                    {
                                        Image(
                                            painter = painterResource(id = R.drawable.prado),
                                            contentDescription = "galaxy",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Text(
                                        text = "Toyota land cruiser prado",
                                        fontSize = 12.sp,
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                    Text(
                                        text = "5 seats 5 doors petrol",
                                        fontSize = 10.sp,
                                        color = Color.DarkGray,
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                    Text(
                                        text = "ksh 9000",
                                        fontSize = 8.sp,
                                        color = Color.DarkGray,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                    Button(onClick = { navController.navigate(ADD_RENTAL_URL) }) {
                                        Text(text = "Rent now")

                                    }
                                }
                            }

                        }
                        Spacer(modifier = Modifier.height(10.dp))


                        Row {
                            Card(
                                modifier = Modifier
                                    .height(250.dp)
                                    .width(180.dp)
                            )
                            {
                                Column {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(135.dp),
                                        contentAlignment = Alignment.Center
                                    )
                                    {
                                        Image(
                                            painter = painterResource(id = R.drawable.rav4),
                                            contentDescription = "galaxy",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Text(
                                        text = "Toyota Rav 4",
                                        fontSize = 12.sp,
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                    Text(
                                        text = "5 seats 5 doors petrol",
                                        fontSize = 12.sp,
                                        color = Color.DarkGray,
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                    Text(
                                        text = "ksh 3000",
                                        fontSize = 10.sp,
                                        color = Color.DarkGray,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )

                                    Button(onClick = { navController.navigate(ADD_RENTAL_URL) }) {
                                        Text(text = "Rent now")

                                    }
                                }

                            }
                            Spacer(modifier = Modifier.width(20.dp))

                            Card(
                                modifier = Modifier
                                    .height(250.dp)
                                    .width(180.dp)
                            )
                            {
                                Column {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(135.dp),
                                        contentAlignment = Alignment.Center
                                    )
                                    {
                                        Image(
                                            painter = painterResource(id = R.drawable.vanguard),
                                            contentDescription = "galaxy",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Text(
                                        text = "Toyota Van guard",
                                        fontSize = 12.sp,
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                    Text(
                                        text = "5 seats 5 doors petrol",
                                        fontSize = 10.sp,
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                    Text(
                                        text = "ksh 4000",
                                        fontSize = 8.sp,
                                        color = Color.DarkGray,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                    Button(onClick = { navController.navigate(ADD_RENTAL_URL) }) {
                                        Text(text = "Rent now")

                                    }
                                }
                            }

                        }
                    }
                }





    }

        )
        Spacer(modifier = Modifier.height(40.dp))
    }
}



val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route="home",
        selectedIcon=Icons.Filled.Home,
        unselectedIcon=Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),



    BottomNavItem(
        title = "Profile",
        route="profile",
        selectedIcon=Icons.Filled.Person,
        unselectedIcon=Icons.Outlined.Person,
        hasNews = false,
        badges=0
    ),
    )



data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon :ImageVector,
    val hasNews :Boolean,
    val badges :Int
)



@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    WazitoECommerceTheme {
        HomeScreen(navController = rememberNavController())
    }
}