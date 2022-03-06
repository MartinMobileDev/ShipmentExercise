package com.example.shipmentexercise.utils

import com.example.shipmentexercise.mainAcitivity.model.Driver
import com.example.shipmentexercise.mainAcitivity.model.Shipment

class DataProvider {
    companion object {
        fun getAllDrivers(): List<Driver> {
            return drivers
        }

        fun getAllShipments(): List<Shipment> {
            return shipments
        }

        private val drivers = listOf(
            Driver(
                name = "Everardo Welch", null, null
            ),
            Driver(
                name = "Orval Mayert", null, null
            ),
            Driver(
                name = "Howard Emmerich", null, null
            ),
            Driver(
                name = "Izaiah Lowe", null, null
            ),
            Driver(
                name = "Monica Hermann", null, null
            ),
            Driver(
                name = "Ellis Wisozk", null, null
            ),
            Driver(
                name = "Noemie Murphy", null, null
            ),
            Driver(
                name = "Cleve Durgan", null, null
            ),
            Driver(
                name = "Murphy Mosciski", null, null
            ),
            Driver(
                name = "Kaiser Sose", null, null
            )
        )

        private val shipments = listOf(
            Shipment(
                address = "215 Osinski Manors"
            ),
            Shipment(
                address = "9856 Marvin Stravenue"
            ),
            Shipment(
                address = "7127 Kathlyn Ferry"
            ),
            Shipment(
                address = "987 Champlin Lake"
            ),
            Shipment(
                address = "63187 Volkman Garden Suite 447"
            ),
            Shipment(
                address = "75855 Dessie Lights"
            ),
            Shipment(
                address = "1797 Adolf Island Apt. 744"
            ),
            Shipment(
                address = "2431 Lindgren Corners"
            ),
            Shipment(
                address = "8725 Aufderhar River Suite 859"
            ),
            Shipment(
                address = "79035 Shanna Light Apt. 322"
            )
        )
    }
}