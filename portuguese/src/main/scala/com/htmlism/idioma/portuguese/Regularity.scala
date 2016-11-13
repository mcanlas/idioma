package com.htmlism.idioma.portuguese

sealed trait Regularity

/**
  * If an inflection is consistent, regardless of conjugation, then it is regular. The pluperfect and future tenses
  * are regular across all conjugations.
  */
case object Regular extends Regularity

/**
  * If an inflection is consistent for all verbs within its conjugation, then it is semi-regular. The present, perfect,
  * and imperfect tenses are this level of regularity.
  */
case object SemiRegular extends Regularity

/**
  * If an inflected form depends on the verb, then it is irregular. Verbs like 'ser' and 'estar' have mostly
  * irregular forms.
  */
case object Irregular extends Regularity
