package com.josequal.josequaltask.fragments.home

import androidx.lifecycle.ViewModel
import com.josequal.josequaltask.R
import com.josequal.josequaltask.donmain.ContactsAndSeasModel
import com.josequal.josequaltask.donmain.InformationModel
import com.josequal.josequaltask.donmain.SelectorModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val informationList = listOf(
        InformationModel(
            1, R.drawable.ic_location, "Get Directions"
        ),
        InformationModel(
            2, R.drawable.ic_phone_purple, "+14 213 00 68 94"
        ),
        InformationModel(
            3, R.drawable.ic_globe, "http://seaseaevent.com?"
        )
    )

    private val contactsList = mutableListOf<ContactsAndSeasModel>()

    private val selectorsList = listOf(
        SelectorModel(1, "Marinier updates", true),
        SelectorModel(2, "News", false),
        SelectorModel(3, "Events", false),
        SelectorModel(4, "Polls", false),
        SelectorModel(5, "Job", false),
        SelectorModel(6, "Events", false),
    )

    private val seasList=listOf(
        ContactsAndSeasModel(1,R.drawable.ic_sea_1,"Mariner Update Title","565677, Revision, Start and End","Date."),
        ContactsAndSeasModel(2,R.drawable.ic_sea_3,"Mariner Update Title","565677, Revision, Start and End","Date."),
        ContactsAndSeasModel(3,R.drawable.ic_sea_2,"Mariner Update Title","565677, Revision, Start and End","Date."),
        ContactsAndSeasModel(4,R.drawable.ic_sea_1,"Mariner Update Title","565677, Revision, Start and End","Date."),
        ContactsAndSeasModel(5,R.drawable.ic_sea_2,"Mariner Update Title","565677, Revision, Start and End","Date."),
    )

    fun getContacts(): MutableList<ContactsAndSeasModel> {
        for (i in 1..5) {
            contactsList.add(
                ContactsAndSeasModel(
                    id = i,
                    R.drawable.ic_contact_image,
                    "Diana Richards",
                    "Sea Freight Operation",
                    "Diana@gmail.com"
                )
            )
        }
        return contactsList
    }

    fun getInformation() = informationList
    fun getSelectors() = selectorsList
    fun getSeas() = seasList
}