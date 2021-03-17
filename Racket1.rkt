#lang racket
; Program to create sentences
(define present_verbs '(eat kill drive buy clean take))
(define past_verbs '(rode ate bought bit moved))
(define objects '(snake car pizza plant cookie camel medicine))
(define present_adverb '(often frequently sometimes rarely today))
(define past_adverb '(yesterday last_month Tuesday))
(define (pick_random l) (list-ref l (random (length l))))
(define (sentence) (list (pick_random present_adverb) 'I
                         (pick_random present_verbs)
                         (pick_random objects)))
