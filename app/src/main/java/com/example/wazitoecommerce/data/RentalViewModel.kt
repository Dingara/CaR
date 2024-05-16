package com.example.wazitoecommerce.data


import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.wazitoecommerce.models.Rental
import com.example.wazitoecommerce.navigation.LOGIN_URL
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class RentalViewModel(var navController:NavHostController, var context: Context) {
    var authViewModel:AuthViewModel
    var progress:ProgressDialog
    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()){
            navController.navigate(LOGIN_URL)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun uploadRental(FullName:String, email:String, PhoneNumber:String,PickupLocation:String,DropOffLocation:String ,PickUpDate:String,ReturnDate:String, filePath:Uri){
        val rentalId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Rentals/$rentalId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var rental = Rental(FullName,email,PhoneNumber,PickupLocation,DropOffLocation,PickUpDate,ReturnDate,imageUrl,rentalId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Rentals/$rentalId")
                    databaseRef.setValue(rental).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }else{
                Toast.makeText(this.context, "Upload error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun allRentals(
        rental:MutableState<Rental>,
        rentals:SnapshotStateList<Rental>):SnapshotStateList<Rental>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Rentals")
        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                rentals.clear()
                for (snap in snapshot.children){
                    var retrievedRental = snap.getValue(Rental::class.java)
                    rental.value = retrievedRental!!
                    rentals.add(retrievedRental)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return rentals
    }

    fun deleteRental(rentalId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Rentals/$rentalId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}