import sys
sys.path.append('../')

from palingrams import load_words

word_list = load_words.load("/Users/jkchandalia/codingdojo/projects/palingrams/words.txt")
anagram_list = []

name = input("Enter a word:")
print("Input name is {}.".format(name))
name = name.lower()
print("Using name {}.".format(name))
name_sorted = sorted(name)

for word in word_list:
    word = word.lower()
    word_sorted = sorted(word)
    if word_sorted == name_sorted and word != name:
        anagram_list.append(word)


print()
print("Number of anagrams is: {}.".format(len(anagram_list)))
print(*anagram_list, sep="\n")