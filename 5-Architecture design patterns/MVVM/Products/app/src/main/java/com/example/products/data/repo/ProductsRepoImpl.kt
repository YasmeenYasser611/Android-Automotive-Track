package com.example.products.data.repo

import com.example.products.data.local.IProuctLocalDataSource
import com.example.products.data.model.Product
import com.example.products.data.remote.IProductRemoteDataSource

class ProductsRepoImpl private constructor(private var productRemoteDataSource : IProductRemoteDataSource , private var productLocalDataSource: IProuctLocalDataSource) : IProductRepo {

    companion object{
        private var instance : ProductsRepoImpl ?= null
        fun getInstance(productRemoteDataSource : IProductRemoteDataSource , productLocalDataSource: IProuctLocalDataSource):ProductsRepoImpl{
            return instance?: synchronized(this){
                val temp = ProductsRepoImpl(productRemoteDataSource , productLocalDataSource)
                instance= temp
                temp
            }
        }
    }
    override suspend fun getProduct(flag: Boolean): List<Product>? {

        return if(flag)
        {
            productRemoteDataSource.makeNetworkCall()
        }
        else{
            productLocalDataSource.getProduct(flag)
        }
    }

    override suspend fun insertProduct(product: Product) {

        productLocalDataSource.insertProduct(product)
    }

    override suspend fun deleteProduct(product: Product) {

        productLocalDataSource.deleteProduct(product)
    }

}