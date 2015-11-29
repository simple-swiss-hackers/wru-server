package ch.simpleswisshackers.backend.models

import ch.simpleswisshackers.backend.models.AdType.AdType
import ch.simpleswisshackers.backend.models.common.Location
import org.joda.time.DateTime


object AdType extends Enumeration {
  type AdType = Value
  val RestaurantAd, DrinkAd, MovieTheaterAd = Value
}

abstract class Ad {
  val adType: AdType

  val distance: Float

  val location: Location

  val startTime: DateTime

  val endTime: DateTime

  val updateDateTime: Option[DateTime]

  val creationDateTime: Option[DateTime]
}





