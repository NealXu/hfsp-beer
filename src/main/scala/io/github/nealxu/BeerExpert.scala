package io.github.nealxu

import io.github.nealxu.BeerColor._

class BeerExpert {

  def getBrands(color: String): List[String] = {
    color match {
      case c if c == AMBER.toString =>
        List("Jack Amber", "Red Moose")
      case _ =>
        List("Jail Pale Ale", "Gout Stout")
    }
  }

}

object BeerExpert {

  def apply(): BeerExpert = new BeerExpert()

}
