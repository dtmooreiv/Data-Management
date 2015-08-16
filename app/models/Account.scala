package models

import play.api.libs.json.Json

case class Account(username: String, passwordHash:String)

object Account {
  implicit val accountFormat = Json.format[Account]
}