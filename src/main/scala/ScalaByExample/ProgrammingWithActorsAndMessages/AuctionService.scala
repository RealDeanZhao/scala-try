//package ScalaByExample.ProgrammingWithActorsAndMessages
//
//import java.util.Date
//
//abstract class AuctionMessage
//
//case class Offer(bid: Int, client: Actor) extends AuctionMessage
//
//case class Inquire(client: Actor) extends AuctionMessage
//
//
//abstract class AuctionReply
//
//case class Status(asked: Int, expire: Date) extends AuctionReply
//
//case object BestOffer extends AuctionReply
//
//case class BeatenOffer(maxBid: Int) extends AuctionReply
//
//case class AuctinConcluded(seller: Actor, client: Actor) extends AuctionReply
//
//case class AuctionFailed extends AuctionReply
//
//case class AuctionOver extends AuctionReply
