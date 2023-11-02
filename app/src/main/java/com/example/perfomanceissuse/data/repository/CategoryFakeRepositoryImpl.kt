package com.example.perfomanceissuse.data.repository

import com.example.perfomanceissuse.domain.model.Category
import com.example.perfomanceissuse.domain.model.Product
import com.example.perfomanceissuse.domain.repository.CategoryRepository
import kotlinx.coroutines.delay
import kotlin.random.Random
import kotlin.random.nextInt

class CategoryFakeRepositoryImpl : CategoryRepository {

    override suspend fun getAllCategories(): List<Category> {
        delay(Random.nextInt(100..500).toLong())
        return getCategories()
    }

    private fun getCategories(): List<Category> {
        return listOf(
            Category.Category1(
                id = "cat1",
                name = "Категория 1",
                products = (getElectronicsList() + getElectronicsList()).shuffled()
            ),
            Category.Category2(
                id = "cat2",
                name = "Категория 2",
                products = (getIHerbLis() + getIHerbLis()).shuffled()
            ),
            Category.Category3(
                id = "cat3",
                name = "Категория 3",
                products = (getIHerbLis() + getElectronicsList()).shuffled()
            ),
            Category.Category2(
                id = "cat4",
                name = "Категория 4",
                products = (getElectronicsList() + getElectronicsList()).shuffled()
            ),
            Category.Category3(
                id = "cat5",
                name = "Категория 5",
                products = (getIHerbLis() + getIHerbLis()).shuffled()
            ),
            Category.Category1(
                id = "cat6",
                name = "Категория 6",
                products = (getIHerbLis() + getElectronicsList()).shuffled()
            ),
            Category.Category3(
                id = "cat7",
                name = "Категория 7",
                products = (getElectronicsList() + getElectronicsList()).shuffled()
            ),
            Category.Category2(
                id = "cat8",
                name = "Категория 8",
                products = (getIHerbLis() + getIHerbLis()).shuffled()
            ),
            Category.Category1(
                id = "cat9",
                name = "Категория 9",
                products = (getIHerbLis() + getElectronicsList()).shuffled()
            ),
            Category.Category2(
                id = "cat 10",
                name = "Категория 10",
                products = (getElectronicsList() + getElectronicsList()).shuffled()
            ),
            Category.Category1(
                id = "cat 11",
                name = "Категория 11",
                products = (getIHerbLis() + getIHerbLis()).shuffled()
            ),
            Category.Category3(
                id = "cat 12",
                name = "Категория 12",
                products = (getIHerbLis() + getElectronicsList()).shuffled()
            ),
        )
    }

    private fun getElectronicsList(): List<Product> {
        return listOf(
            Product(
                name = "Смартфон Xiaomi POCO M5s 6/128 ГБ",
                imageUrl = "https://avatars.mds.yandex.net/get-mpic/5320264/img_id3549934561096180184.jpeg/x248_trim",
                priceOld = "14 990 ₽",
                priceNew = "14 690 ₽",
            ),
            Product(
                name = "Смартфон Infinix NOTE 30i 8+256GB",
                imageUrl = "https://avatars.mds.yandex.net/get-mpic/4493501/img_id8103449969781128226.jpeg/x248_trim",
                priceOld = "1115 300",
                priceNew = "2217 008",
            ),
            Product(
                name = "Смартфон Google Pixel 7A 8/128 ГБ JP,",
                imageUrl = "https://avatars.mds.yandex.net/get-mpic/1537623/img_id1922984020970809711.jpeg/x248_trim",
                priceOld = "40 308",
                priceNew = "39 000",
            ),
            Product(
                name = "Смартфон Xiaomi POCO M5s 6/128 ГБ",
                imageUrl = "https://avatars.mds.yandex.net/get-mpic/5320264/img_id3549934561096180184.jpeg/x248_trim",
                priceOld = "14 990 ₽",
                priceNew = "14 690 ₽",
            ),
            Product(
                name = "Смартфон Infinix NOTE 30i 8+256GB",
                imageUrl = "https://avatars.mds.yandex.net/get-mpic/4493501/img_id8103449969781128226.jpeg/x248_trim",
                priceOld = "115 300",
                priceNew = "187 008",
            ),
            Product(
                name = "Смартфон Google Pixel 7A 8/128 ГБ JP,",
                imageUrl = "https://avatars.mds.yandex.net/get-mpic/1537623/img_id1922984020970809711.jpeg/x248_trim",
                priceOld = "240 308",
                priceNew = "339 000",
            ),
        )
    }

    private fun getIHerbLis() = listOf(
        Product(
            name = "CollagenUP California (Коллаген Ап) 206 гр. от California Gold",
            imageUrl = "https://avatars.mds.yandex.net/get-mpic/5194288/img_id5221372819917291950.jpeg/x248_trim",
            priceNew = "1 623",
            priceOld = "2 000",
        ),
        Product(
            name = "California Gold Nutrition Omega 800 Fish oil капс., 300 г",
            imageUrl = "https://avatars.mds.yandex.net/get-mpic/4399709/img_id3445360414755258394.jpeg/x248_trim",
            priceNew = "2 415",
            priceOld = "3 345",
        ),
        Product(
            name = "Now Foods Chlorophyll Жидкий хлорофилл, аромат",
            imageUrl = "https://avatars.mds.yandex.net/get-mpic/5269959/img_id8191840888809131163.jpeg/x248_trim",
            priceNew = "1 315",
            priceOld = "1 545",
        ),
        Product(
            name = "CollagenUP California (Коллаген Ап) 206 гр. от California Gold",
            imageUrl = "https://avatars.mds.yandex.net/get-mpic/5194288/img_id5221372819917291950.jpeg/x248_trim",
            priceNew = "61 623",
            priceOld = "62 000",
        ),
        Product(
            name = "California Gold Nutrition Omega 800 Fish oil капс., 300 г",
            imageUrl = "https://avatars.mds.yandex.net/get-mpic/4399709/img_id3445360414755258394.jpeg/x248_trim",
            priceNew = "12 415",
            priceOld = "3 345",
        ),
        Product(
            name = "Now Foods Chlorophyll Жидкий хлорофилл, аромат",
            imageUrl = "https://avatars.mds.yandex.net/get-mpic/5269959/img_id8191840888809131163.jpeg/x248_trim",
            priceNew = "41 315",
            priceOld = "1 545",
        ),
    )
}
