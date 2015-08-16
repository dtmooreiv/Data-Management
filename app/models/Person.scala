package models

import com.github.nscala_time.time.Imports._
import play.api.libs.json.Json

case class Person( name: String, dob: DateTime, address: String)

object Person {

  implicit val personFormat = Json.format[Person]
}