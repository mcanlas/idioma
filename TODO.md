# Next actions

* use H2 for querying
* model verb and noun relationships
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

# App

* bilingual dictinary string search (ignore accents)
  * left side portuguese, right side english (w/e)
