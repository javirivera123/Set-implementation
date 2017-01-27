# Set-implementation
Naively a set is only a collection of objects, but even in this level of generality we can make sense of operations on sets, as arithmetical operations on integers, so we define • (Intersection) A ∩ B = {x | x ∈ A and x ∈ B} • (Union) A ∪ B = {x | x ∈ A or x ∈ B} • (Difference) A \ B = {x | x ∈ A but x 6∈ B} • (Power) P(A) = {x | x ⊂ A} whenever A and B are sets. For example, if we assign A = {1, 2, 3} and B = {2, 3, 4} then • A ∩ B = {2, 3} • A ∪ B = {1, 2, 3, 4} • A \ B = {1} • P(A) = {∅, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, A}. #  
# Problem
Create a class named Set that implements all the above set operations along with an appropriate toString() method. 
