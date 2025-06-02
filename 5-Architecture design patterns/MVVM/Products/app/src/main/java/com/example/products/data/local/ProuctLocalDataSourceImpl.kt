package com.example.products.data.local

import com.example.day1.model.local.IProductDao
import com.example.products.data.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProuctLocalDataSourceImpl(val dao : IProductDao): IProuctLocalDataSource {
    override suspend fun insertProduct(product: Product) {
        withContext(Dispatchers.IO)
        {
            dao.insert(product)
        }
    }

    override suspend fun deleteProduct(product: Product) {
        withContext(Dispatchers.IO)
        {
            dao.delete(product)
        }
    }

    override suspend fun getProduct(flag: Boolean): List<Product> {
        return withContext(Dispatchers.IO)
        {
            dao.getAllProducts()
        }
    }
}