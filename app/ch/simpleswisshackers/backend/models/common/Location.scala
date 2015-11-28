package ch.simpleswisshackers.backend.models.common

import play.api.libs.json._
import play.api.libs.functional.syntax._

object Location {

  implicit val locationReads: Reads[Location] = (
    (JsPath \ "latitude").read[Double] and
    (JsPath \ "longitude").read[Double]
  )(Location.apply _)


  implicit val locationWrites = new Writes[Location] {
    def writes(location: Location) = Json.obj(
      "latitude" -> location.latitude,
      "longitude" -> location.longitude
    )
  }

}

case class Location(latitude: Double, longitude: Double)