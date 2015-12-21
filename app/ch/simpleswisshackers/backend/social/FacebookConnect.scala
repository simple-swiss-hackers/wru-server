package ch.simpleswisshackers.backend.social

import com.restfb.types.User
import com.restfb.{Parameter, Version, DefaultFacebookClient, FacebookClient}
import play.api._

object FacebookConnect {

  val APP_ID = "1493117471018513"
  val APP_SECRET = "dafada10f34d26f5549014cdfe83d264"


  def identifyMe(accessToken: String): Option[User] = {

    val fbc: FacebookClient = new DefaultFacebookClient(accessToken, APP_SECRET, Version.VERSION_2_5)
    val user: Option[User] = None

    try {
      Some(fbc.fetchObject("me", classOf[User], Parameter.`with`("fields", "id,first_name,last_name")))

    } catch {
      case error: Exception => {
        Logger.debug(s"FacebookConnect.identifyMe: Unable to log ${accessToken}")
        None
      }
    }
  }
}