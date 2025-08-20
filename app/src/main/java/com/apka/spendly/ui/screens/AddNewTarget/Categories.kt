package com.apka.spendly.ui.screens.AddNewTarget

import androidx.compose.ui.graphics.vector.ImageVector
import com.apka.spendly.ui.imageVector.BeautyIcon
import com.apka.spendly.ui.imageVector.CarIcon
import com.apka.spendly.ui.imageVector.ClothesIcon
import com.apka.spendly.ui.imageVector.EducationIcon
import com.apka.spendly.ui.imageVector.EntertainmentIcon
import com.apka.spendly.ui.imageVector.FamilyIcon
import com.apka.spendly.ui.imageVector.FoodIcon
import com.apka.spendly.ui.imageVector.GadgetIcon
import com.apka.spendly.ui.imageVector.GiftsIcon
import com.apka.spendly.ui.imageVector.HealthIcon
import com.apka.spendly.ui.imageVector.HousingIcon
import com.apka.spendly.ui.imageVector.InvestmentsIcon
import com.apka.spendly.ui.imageVector.OtherIcon
import com.apka.spendly.ui.imageVector.PetsIcon
import com.apka.spendly.ui.imageVector.SavingsIcon
import com.apka.spendly.ui.imageVector.ShoppingIcon
import com.apka.spendly.ui.imageVector.SportIcon
import com.apka.spendly.ui.imageVector.TravelIcon

enum class Categories(
    val title: String,
    val icon: ImageVector
) {
    TRAVEL("Travel", TravelIcon),
    HOUSING("Housing", HousingIcon),
    EDUCATION("Education", EducationIcon),
    CAR("Car", CarIcon),
    HEALTH("Health", HealthIcon),
    SAVINGS("Savings", SavingsIcon),
    ENTERTAINMENT("Entertainment", EntertainmentIcon),
    FOOD("Food & Drinks", FoodIcon),
    CLOTHES("Clothes", ClothesIcon),
    SHOPPING("Shopping", ShoppingIcon),
    TECHNOLOGY("Technology & Gadgets", GadgetIcon),
    SPORTS("Sports & Fitness", SportIcon),
    FAMILY("Family & Kids", FamilyIcon),
    GIFTS("Gifts", GiftsIcon),
    PETS("Pets", PetsIcon),
    BEAUTY("Beauty & Personal Care", BeautyIcon),
    INVESTMENTS("Investments", InvestmentsIcon),
    OTHER("Other", OtherIcon);

    companion object {
        fun fromTitle(title: String): Categories? =
            entries.find { it.title == title }
    }
}