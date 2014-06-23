# Next actions

* can em/no/na
* can de/do/da
* syllable count
* word generator feeds lookup/dictionary
  * given exact form, give back possible meanings and canonical form
  * inflected, reflexive, plural, gendered, etc
* copula's must be different (copulas do not form full sentences)
* need to store verb transitivity
* need topics/associations/high collocations
  * maybe classify nouns into topical groups (person place thing activty idea)

# Phrase generator
* yields multiple possibilities of List[Words] ("a gente" being one option)
  * Phrase == List[Words], yields Iterator[Phrases]
* could include another phrase generator
  * e.g. (bingo book,book bag,bean machine) or ($color ++ $animal)
* always yields iterator (do not manifest into list for large/complex sentences)
* has sample function (picks random iterator at each level, not truly a random distribution of all possible phrases)
* constructor takes list of phrases, like a set?
  * Phrase(Jan, Feb, Mar), or of bottom type phrase
* Phrase($color, $animal)
* Phrase("my", $animal)
* may need PhraseAnd() and PhraseOr() constructors?

# UI Epic

* JS/drag word parts generator. like madlibs/duolingo. automatically creates generators
  * maybe start with free text input that gets selectively promoted into word groups (verb menu, subject menu, first subject marker, second subject marker, etc)
  * can select based on dictionaries emitted by word generator (links back to lexeme/canonical form)

# Verb Trainer Epic

* based on spaced repetition
* slide down to reveal answer
* tap left/right for wrong/right
* awards points based on regularity of conjugation
  * irregular forms award points only on themselves (means comes up more during practice
  * semiiregular forms (local conjugation forms) award points to the conjugation only
  * regular forms award points to all conjugations
* needs a sorted list of all words and their success points so far
  * success on a word increments the success of all related words (based on regularity)
  * next word is a random selection of the words with the least success
  * seeking collection class that implements random updates and constantly sorted
