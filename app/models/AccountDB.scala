package models

import sorm._

object AccountDB extends Instance(entities = Seq(Entity[Account]()), url = "jdbc:h2:mem:test")
