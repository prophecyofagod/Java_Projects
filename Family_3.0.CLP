(deftemplate father-of (slot father) (slot child))
(deftemplate mother-of (slot mother) (slot child))
(deftemplate male (slot person))
(deftemplate female (slot person))
(deftemplate wife-of (slot wife) (slot husband))
(deftemplate husband-of (slot husband) (slot wife))
(deftemplate parent-of (slot parent) (slot child))
(deftemplate sibling-of (slot child1) (slot child2))
(deftemplate first-cousin-of (slot cousin1) (slot cousin2))
(deftemplate second-cousin-of (slot cousin1) (slot cousin2))
(deftemplate grandfather-of (slot grandfather) (slot grandchild))
(deftemplate grandmother-of (slot grandmother) (slot grandchild))
(deftemplate grandparent-of (slot grandparent) (slot grandchild))
(deftemplate aunt-of (slot aunt) (slot person))
(deftemplate uncle-of (slot uncle) (slot person))
(deffacts families
	(father-of (father fred) (child phil))
	(father-of (father fred) (child rachel))
	(mother-of (mother gail) (child phil))
	(mother-of (mother gail) (child rachel))
	(male (person phil))
	(female (person rachel))
  (male (person andy))
  (male (person nathan))
  (male (person andrew))
	(father-of (father henry) (child fred))
	(father-of (father eugene) (child gail))
	(mother-of (mother gert_s) (child fred))
	(mother-of (mother gert_g) (child gail))
	(father-of (father eugene) (child hope))
	(father-of (father eugene) (child mary))
	(mother-of (mother gert_g) (child hope))
	(mother-of (mother gert_g) (child mary))
	(father-of (father henry) (child bob))
	(mother-of (mother gert_s) (child bob))
	(father-of (father henry) (child bob))
	(mother-of (mother gert_s) (child bob))
	(mother-of (mother gert_g) (child mary))
	(mother-of (mother gert_g) (child hope))
	(father-of (father phil) (child jacob))
	(father-of (father phil) (child esther))
	(father-of (father phil) (child ben))
	(mother-of (mother kerri) (child ben))
	(mother-of (mother kerri) (child jacob))
	(mother-of (mother kerri) (child esther))
	(mother-of (mother mary) (child jon))
	(mother-of (mother mary) (child james))
	(mother-of (mother mary) (child matthew))
	(father-of (father tom) (child jon))
	(father-of (father tom) (child matthew))
	(father-of (father tom) (child james))
	(father-of (father bob) (child jim))
	(father-of (father bob) (child andrew))
	(father-of (father bob) (child rob))
	(mother-of (mother lois) (child rob))
	(mother-of (mother lois) (child andrew))
	(mother-of (mother lois) (child jim))
	(mother-of (mother hope) (child nathan))
	(mother-of (mother hope) (child andy))
	(mother-of (mother hope) (child suzi))
	(father-of (father bill) (child nathan))
	(father-of (father bill) (child suzi))
	(father-of (father bill) (child andy))
	(father-of (father rob) (child rj))
	(father-of (father rob) (child kim))
	(mother-of (mother kathy) (child rj))
	(mother-of (mother kathy) (child kim))
	(mother-of (mother bertha) (child gert_g))
	(mother-of (mother bertha) (child al))
	(mother-of (mother bertha) (child sally))
)
(defrule parent
(or (father-of (father ?a) (child ?b))
    (mother-of (mother ?a) (child ?b)))
=>
(assert (parent-of (parent ?a) (child ?b))))

(defrule wife-of
(mother-of (mother ?a)(child ?b))
(father-of (father ?c)(child ?b))
=>
(assert (wife-of (wife ?a) (husband ?c))))

(defrule husband-of
(father-of (father ?a)(child ?b))
(mother-of (mother ?c)(child ?b))
=>
(assert (husband-of (husband ?a) (wife ?c))))

(defrule grandfather
(parent-of (parent ?a) (child ?b))
(father-of (father ?c) (child ?a))
=>
(assert (grandfather-of (grandfather ?c) (grandchild ?b))))

(defrule grandmother
(parent-of (parent ?a) (child ?b))
(mother-of (mother ?c) (child ?a))
=>
(assert (grandmother-of (grandmother ?c) (grandchild ?b))))

(defrule grandparent
(parent-of (parent ?a) (child ?b))
(parent-of (parent ?c) (child ?a))
=>
(assert (grandparent-of (grandparent ?c) (grandchild ?b))))

(defrule ismale
(father-of (father ?a) (child ?b))
=>
(assert (male (person ?a))))

(defrule uncle
(or (and(parent-of (parent ?A) (child ?B))	;your parent
    (sibling-of (child1 ?A) (child2 ?C))		;your blood uncle
    (male (person ?C)))
(and (parent-of (parent ?A) (child ?B))		;your parent
     (sibling-of (child1 ?A) (child2 ?D))		;your blood aunt
     (female (person ?D))				
     (husband-of (husband ?C) (wife ?D))))		;your married uncle
=>
(assert (uncle-of (uncle ?C) (person ?B))))

(defrule aunt
(or (and(parent-of (parent ?A) (child ?B))	;your parent
(parent-of (parent ?C) (child ?A))		;your grandparent
(parent-of (parent ?C) (child ?D))		;your blood aunt
(female (person ?D))
(not (mother-of (mother ?D) (child ?B))))
(and (parent-of (parent ?A) (child ?B))		;your parent		
(parent-of (parent ?C) (child ?A))		;your grandparent
(parent-of (parent ?C) (child ?E))		;your uncle
(male (person ?E))		
(not (father-of (father ?E) (child ?B)))	
(father-of (father ?E) (child ?F))		;your cousin
(mother-of (mother ?D) (child ?F))))		;your married aunt
=>
(assert (aunt-of (aunt ?D) (person ?B))))

(defrule first-cousin
(parent-of (parent ?A) (child ?B))		;your parent
(parent-of (parent ?C) (child ?A))		;your grandparent
(parent-of (parent ?C) (child ?D))		;your aunt/uncle
(not (parent-of (parent ?D) (child ?B)))
(parent-of (parent ?D) (child ?E))		;your cousin
=>
(assert (first-cousin-of (cousin1 ?E) (cousin2 ?B))))

(defrule second-cousin
(parent-of (parent ?A) (child ?B))		;your parent
(parent-of (parent ?C) (child ?A))		;your grandparent
(parent-of (parent ?C) (child ?D))		;your uncle
(not (parent-of (parent ?D) (child ?B)))
(parent-of (parent ?D) (child ?E))		;your cousin
(parent-of (parent ?E) (child ?F))		;your cousins child
=>
(assert (second-cousin-of (cousin1 ?B)(cousin2 ?F))))

(defrule sibling
(parent-of (parent ?A) (child ?B))		;your parent
(parent-of (parent ?A) (child ?C))		;your sibling
(test(neq ?B ?C))
=>
(assert (sibling-of (child1 ?C) (child2 ?B))))

(defrule find_parents
(find-parent-of ?child)
(parent-of (parent ?a) (child ?child))
=>
(printout t ?a " is the parent of " ?child crlf))

(defrule find_grandchildren
(find-grandchildren-of ?grandparent)
(grandparent-of (grandparent ?grandparent) (grandchild ?a))
=>
(printout t ?a " is the grandchild of " ?grandparent crlf))
