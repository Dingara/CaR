package com.example.wazitoecommerce.ui.theme.screens.rent


import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wazitoecommerce.data.RentalViewModel
import com.example.wazitoecommerce.ui.theme.WazitoECommerceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddRentalDetails(navController:NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Add your details",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )

        var FullName by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var PhoneNumber by remember { mutableStateOf("") }
        var PickupLocation by remember { mutableStateOf("") }
        var DropOffLocation by remember { mutableStateOf("") }
        var PickUpDate by remember { mutableStateOf("") }
        var ReturnDate by remember { mutableStateOf("") }
        val context = LocalContext.current

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = FullName,
            onValueChange = { FullName = it },
            label = { Text(text = "Full name *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = PhoneNumber,
            onValueChange = { PhoneNumber = it },
            label = { Text(text = "Phone number *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = PickupLocation,
            onValueChange = { PickupLocation = it },
            label = { Text(text = "Pickup location *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = DropOffLocation,
            onValueChange = { DropOffLocation = it },
            label = { Text(text = "Drop off location *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = PickUpDate,
            onValueChange = { PickUpDate = it },
            label = { Text(text = "Pickup date *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = ReturnDate,
            onValueChange = { ReturnDate = it },
            label = { Text(text = "Return date *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))



        //---------------------IMAGE PICKER START-----------------------------------//

        var modifier = Modifier
        ImagePicker(modifier,context, navController, FullName.trim(), email.trim(), PhoneNumber.trim(), PickupLocation.trim(), DropOffLocation.trim(), PickUpDate.trim(), ReturnDate.trim())

        //---------------------IMAGE PICKER END-----------------------------------//



    }
}

@Composable
fun ImagePicker(modifier: Modifier = Modifier, context: Context,navController: NavHostController,FullName:String, email:String, PhoneNumber:String,PickupLocation:String,DropOffLocation:String ,PickUpDate:String,ReturnDate:String) {
    var hasImage by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    Column(modifier = modifier,) {
        if (hasImage && imageUri != null) {
            val bitmap = MediaStore.Images.Media.
            getBitmap(context.contentResolver,imageUri)
            Image(bitmap = bitmap.asImageBitmap(), contentDescription = "Selected image")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp), horizontalAlignment = Alignment.CenterHorizontally,) {
            Button(
                onClick = {
                    imagePicker.launch("image/*")
                },
            ) {
                Text(
                    text = "Select Image"
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                //-----------WRITE THE UPLOAD LOGIC HERE---------------//
                var RentalRepository = RentalViewModel(navController,context)
                RentalRepository.uploadRental(FullName,email,PhoneNumber,PickupLocation,DropOffLocation,PickUpDate,ReturnDate,imageUri!!)


            }) {
                Text(text = "Upload")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AddRentalDetailsPreview(){
    WazitoECommerceTheme {
        AddRentalDetails(navController = rememberNavController())
    }
}