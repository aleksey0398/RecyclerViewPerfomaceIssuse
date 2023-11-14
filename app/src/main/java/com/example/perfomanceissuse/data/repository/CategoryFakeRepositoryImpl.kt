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
            Category(
                id = "cat1",
                name = "Категория 1",
                products = getElectronicsList("Cat 1")
            ),
            Category(
                id = "cat2",
                name = "Категория 2",
                products = getElectronicsList("Cat 2")
            ),
            Category(
                id = "cat3",
                name = "Категория 3",
                products = getElectronicsList("Cat 3")
            ),
            Category(
                id = "cat4",
                name = "Категория 4",
                products = getElectronicsList("Cat 4")
            ),
            Category(
                id = "cat5",
                name = "Категория 5",
                products = getElectronicsList("Cat 5")
            ),
            Category(
                id = "cat6",
                name = "Категория 6",
                products = getIHerbLis("Cat 6")
            ),
            Category(
                id = "cat7",
                name = "Категория 7",
                products = getIHerbLis("Cat 7")
            ),
            Category(
                id = "cat8",
                name = "Категория 8",
                products = getIHerbLis("Cat 8")
            ),
            Category(
                id = "cat9",
                name = "Категория 9",
                products = getIHerbLis("Cat 9")
            ),
            Category(
                id = "cat 10",
                name = "Категория 10",
                products = getIHerbLis("Cat 10")
            ),
            Category(
                id = "cat 11",
                name = "Категория 11",
                products = getIHerbLis("Cat 11")
            ),
            Category(
                id = "cat 12",
                name = "Категория 12",
                products = getIHerbLis("Cat 12")
            ),
        )
    }

    private fun getElectronicsList(
        name: String,
    ): List<Product> {
        return listOf(
            Product(
                name = "Electric $name 1",
                imageUrl = "https://avatars.mds.yandex.net/get-mpic/5320264/img_id3549934561096180184.jpeg/x248_trim",
                priceOld = "14 990 ₽",
                priceNew = "14 690 ₽",
            ),
            Product(
                name = "Electric $name 2",
                imageUrl = "https://avatars.mds.yandex.net/get-mpic/4493501/img_id8103449969781128226.jpeg/x248_trim",
                priceOld = "111 300 ₽",
                priceNew = "221 008 ₽",
            ),
            Product(
                name = "Electric $name 3",
                imageUrl = "https://avatars.mds.yandex.net/get-mpic/1537623/img_id1922984020970809711.jpeg/x248_trim",
                priceOld = "40 308 ₽",
                priceNew = "39 000 ₽",
            ),
            Product(
                name = "Electric $name 4",
                imageUrl = "https://avatars.mds.yandex.net/get-mpic/5320264/img_id3549934561096180184.jpeg/x248_trim",
                priceOld = "14 990 ₽",
                priceNew = "14 690 ₽",
            ),
            Product(
                name = "Electric $name 5",
                imageUrl = "https://avatars.mds.yandex.net/get-mpic/4493501/img_id8103449969781128226.jpeg/x248_trim",
                priceOld = "115 300 ₽",
                priceNew = "187 008 ₽",
            ),
            Product(
                name = "Electric $name 6",
                imageUrl = "https://avatars.mds.yandex.net/get-mpic/1537623/img_id1922984020970809711.jpeg/x248_trim",
                priceOld = "240 308 ₽",
                priceNew = "339 000 ₽",
            ),
        )
    }

    private fun getIHerbLis(
        name: String,
    ) = listOf(
        Product(
            name = "iHerb $name 1",
            imageUrl = "https://avatars.mds.yandex.net/get-mpic/5194288/img_id5221372819917291950.jpeg/x248_trim",
            priceNew = "1 623 ₽",
            priceOld = "2 000 ₽",
        ),
        Product(
            name = "iHerb $name 2",
            imageUrl = "https://avatars.mds.yandex.net/get-mpic/4399709/img_id3445360414755258394.jpeg/x248_trim",
            priceNew = "2 415 ₽",
            priceOld = "3 345 ₽",
        ),
        Product(
            name = "iHerb $name 3",
            imageUrl = "https://avatars.mds.yandex.net/get-mpic/5269959/img_id8191840888809131163.jpeg/x248_trim",
            priceNew = "1 315 ₽",
            priceOld = "1 545 ₽",
        ),
        Product(
            name = "iHerb $name 4",
            imageUrl = "https://avatars.mds.yandex.net/get-mpic/5194288/img_id5221372819917291950.jpeg/x248_trim",
            priceNew = "61 623 ₽",
            priceOld = "62 000 ₽",
        ),
        Product(
            name = "iHerb $name 5",
            imageUrl = "https://avatars.mds.yandex.net/get-mpic/4399709/img_id3445360414755258394.jpeg/x248_trim",
            priceNew = "12 415 ₽",
            priceOld = "3 345 ₽",
        ),
        Product(
            name = "iHerb $name 6",
            imageUrl = "https://avatars.mds.yandex.net/get-mpic/5269959/img_id8191840888809131163.jpeg/x248_trim",
            priceNew = "41 315 ₽",
            priceOld = "1 545 ₽",
        ),
    )
}
