package ch.simpleswisshackers.backend.models

import ch.simpleswisshackers.backend.models.common.Location
import org.joda.time.DateTime

import play.api.libs.json._
import play.api.libs.functional.syntax._


object User {

  val userReadsBuilder =
    (__ \ "facebookId").read[String] and
    (__ \ "facebookToken").read[String] and
    (__ \ "pushToken").readNullable[String] and
    (__ \ "location").readNullable[Location]


  implicit val userReads: Reads[User] = userReadsBuilder.apply(
    (facebookId, facebookToken, pushToken, location) =>
      User(facebookId, facebookToken, pushToken, location)
  )

  implicit val userWrites = new Writes[User] {
    def writes(user: User) = {
      var json = Json.obj(
        "facebookId" -> user.facebookId,
        "facebookToken" -> user.facebookToken
      )

      user.pushToken.foreach( token => json = json ++ Json.obj("pushToken" -> token) )
      user.location.foreach( location => json = json ++ Json.obj("location" -> Json.toJson(location)))
      user.updateDateTime.foreach( date => json = json ++ Json.obj("updateTime" -> date.toString()))
      user.creationDateTime.foreach( date => json = json ++ Json.obj("creationTime" -> date.toString()))

      json
    }
  }
}

case class User(
                 facebookId: String,
                 facebookToken: String,
                 pushToken: Option[String] = None,
                 location: Option[Location] = None,
                 updateDateTime: Option[DateTime] = None,
                 creationDateTime: Option[DateTime] = None
               ) {


  def addCreationDateTime(): User =
    this.copy(creationDateTime = Some(DateTime.now()), updateDateTime = Some(DateTime.now()))

  def updateUpdateDateTime(): User =
    this.copy(updateDateTime = Some(DateTime.now()))
}
