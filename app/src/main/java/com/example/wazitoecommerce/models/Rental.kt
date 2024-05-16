package com.example.wazitoecommerce.models

class Rental {var FullName:String = ""
    var email:String = ""
    var PhoneNumber:String = ""
    var PickupLocation:String = ""
    var DropOffLocation:String = ""
    var PickUpDate:String = ""
    var ReturnDate:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(FullName:String, email:String, PhoneNumber:String,PickupLocation:String,DropOffLocation:String ,PickUpDate:String,ReturnDate:String,imageUrl: String, id: String) {
        this.FullName = FullName
        this.email = email
        this.PhoneNumber = PhoneNumber
        this.PickupLocation = PickupLocation
        this.DropOffLocation = DropOffLocation
        this.PickUpDate = PickUpDate
        this.ReturnDate = ReturnDate
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}
