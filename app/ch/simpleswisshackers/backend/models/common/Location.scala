package ch.simpleswisshackers.backend.models.common

import play.api.libs.json._
import play.api.libs.functional.syntax._

object Location {

  implicit val locationReads: Reads[Location] = (
    (JsPath \ "lat").read[Double] and
    (JsPath \ "lon").read[Double]
  )(Location.apply _)


  implicit val locationWrites = new Writes[Location] {
    def writes(location: Location) = Json.obj(
      "lat" -> location.latitude,
      "lon" -> location.longitude
    )
  }

}

case class Location(latitude: Double, longitude: Double)