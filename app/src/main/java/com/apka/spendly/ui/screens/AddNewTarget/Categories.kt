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
    TRAVEL("Подорожі", TravelIcon),
    HOUSING("Житло", HousingIcon),
    EDUCATION("Освіта", EducationIcon),
    CAR("Автомобіль", CarIcon),
    HEALTH("Здоров'я", HealthIcon),
    SAVINGS("Заощадження", SavingsIcon),
    ENTERTAINMENT("Розваги", EntertainmentIcon),
    FOOD("Їжа", FoodIcon),
    CLOTHES("Одяг", ClothesIcon),
    SHOPPING("Покупки", ShoppingIcon),
    TECHNOLOGY("Технології та гаджети", GadgetIcon),
    SPORTS("Спорт та фітнес", SportIcon),
    FAMILY("Сім'я та діти", FamilyIcon),
    GIFTS("Подарунки", GiftsIcon),
    PETS("Домашні тварини", PetsIcon),
    BEAUTY("Краса та особистий догляд", BeautyIcon),
    INVESTMENTS("Інвестиції", InvestmentsIcon),
    OTHER("Інше", OtherIcon);

    companion object {
        fun fromTitle(title: String): Categories? =
            entries.find { it.title == title }
    }
}