package cs3500.hw02;

/**
 * Type for the three types of piles in a game of Freecell. <br>
 * Open: This pile can hold only one card. It is like a buffer to temporarily
 * hold cards <br>
 * Cascade: This is a pile of face-up cards. A build within a cascade
 * pile is a subset of cards that has monotonically decreasing values and suits
 * of alternating colors<br>
 * Foundation: Initially empty, there are 4 foundation
 * piles, one for each suit. Each foundation pile collects cards in increasing
 * order of value for one suit (Ace being the lowest). <br>
 * The goal of the game is to fill up all the foundation piles.
 */

/**
 * PileType represents an enumeration of three different pile types.
 * Pile type is one of:
 * -OPEN
 * -CASCADE
 * -FOUNDATION
 */
public enum PileType {
  /**
   * OPEN (PileType) represents an open pile.
   * Usually a game of Freecell has four open piles, but our game will allow as few as one.
   * An open pile may contain at most one card.
   * An open pile is usually used as a temporary buffer during the game to hold cards.
   */
  OPEN,
  /**
   * CASCADE (PileType) represents a cascade pile. Cascade pile are indexed starting from 1. Usually
   * a game of Freecell has eight cascade piles, but our game will allow as few as four. Because the
   * initial deal of the game is shuffled (see below), a cascade pile may initially contain cards in
   * any order. However, a card from some pile can be moved to the end of a cascade pile if and only
   * if its color is different from that of the currently last card, and its value is exactly one
   * less than that of the currently last card.
   */
  CASCADE,
  /**
   * FOUNDATION (PileType) represents a foundation pile There are four foundation piles, one for
   * each suit, and indexed 1 through 4. These four piles are initially empty, and the goal of
   * Freecell is to collect all cards of all suits in their respective foundation piles. A card can
   * be added to a foundation pile if and only if its suit matches that of the pile, and its value
   * is one more than that of the card currently on top of the pile.
   * If a foundation pile is currently empty, any ace can be added to it: there is no required
   * ordering of suits in the foundation piles.
   */
  FOUNDATION
}
