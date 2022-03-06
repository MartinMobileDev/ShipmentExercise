package com.example.shipmentexercise.mainAcitivity.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shipmentexercise.mainAcitivity.model.Driver
import com.example.shipmentexercise.mainAcitivity.model.Shipment
import com.example.shipmentexercise.utils.DataProvider
import java.util.*

class MainViewModel : ViewModel() {
    val driverModel = MutableLiveData<List<Driver>>()
    private val shipmentsModel = MutableLiveData<List<Shipment>>()

    fun getAllDrivers() {
        val driversList: List<Driver> = DataProvider.getAllDrivers()
        driverModel.postValue(driversList)
    }

    fun getAllShipments() {
        val shipmentList: List<Shipment> = DataProvider.getAllShipments()
        shipmentsModel.postValue(shipmentList)
    }

    fun calculateSS(driver: Driver) {
        val shipmentList = mutableListOf<Pair<String, Float>>()
        var scoreAux: Float
        if (driver.shipment == null) {
            shipmentsModel.value?.forEach { shipment ->
                scoreAux = if (shipment.address.length % 2 == 0) {
                    countVowelsAndConsonants(driver).first * 1.5f
                } else {
                    countVowelsAndConsonants(driver).second.toFloat()
                }
                if (findGcd(shipment.address.length, driver.name.length) != 1) {
                    scoreAux *= 1.5f
                }
                shipmentList.add(Pair(shipment.address, scoreAux))
            }

            run finder@{
                shipmentList.sortedByDescending { it.second }.forEach { shipment ->
                    if (!driverModel.value?.any { driver -> driver.shipment == shipment.first }!!) {
                        driverModel.value?.find { driverAux -> driverAux.name == driver.name }
                            ?.shipment = shipment.first
                        driverModel.value?.find { driverAux -> driverAux.name == driver.name }
                            ?.score = shipment.second
                        driverModel.postValue(driverModel.value)
                        return@finder
                    }
                }
            }
        }
    }

    private fun findGcd(n1: Int, n2: Int): Int {
        if (n2 == 0) {
            return n1
        }
        return findGcd(n2, n1 % n2)
    }

    private fun countVowelsAndConsonants(driver: Driver): Pair<Int, Int> {
        var vowels = 0
        var consonants = 0
        for (ch in driver.name.lowercase(Locale.getDefault())) {
            when (ch) {
                'a', 'e', 'i', 'o', 'u' -> ++vowels
                in 'a'..'z' -> ++consonants
            }
        }
        return Pair(vowels, consonants)
    }
}