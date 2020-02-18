import sys
from collections import Counter
sys.path.append("./..")
from palingrams import load_words

word_file = load_words.load("/Users/jkchandalia/codingdojo/projects/palingrams/words.txt")
word_file.append('a')
word_file.append('i')
word_file = set(word_file)

init_name = str(input("Enter a name or phrase for which you'd like to find an anagram:")).lower()

def find_contained_anagrams(word_list, name):
    """Read in an iterator of a word dictionary and a name and return all anagrams in name."""
    name_map = Counter(name)
    anagrams = []
    for word in word_list:
        word_map = Counter(word)
        contained = True
        for char in word_map:
            if name_map[char]<word_map[char]:
                contained = False
                break
        if contained:
            anagrams.append(word)
    
    print(*anagrams, sep="\n")
    print()
    print("Remaining letters = {}".format("".join(name)))
    print("Nubmer of remaining letters = {}".format(len(name)))
    print("{} anagrams found".format(len(anagrams)))
    return anagrams


def process_choice(name):
    """Check user choice for validity and return remaining letters."""
    while True:
        choice = str(input("Enter your choice from those suggested or Enter to start over or # to end:")).lower()
        if choice == '':
            main()
        elif choice == '#':
            sys.exit()
        else:
            candidate = choice
    
        remaining_letters = list(name)
        contained = True
        for char in candidate:
            if char in remaining_letters:
                remaining_letters.remove(char)
            else:
                contained = False
                break
        if contained:
            break
        else:
            print("Won't work! Make another choice!")
    return candidate, remaining_letters


def main():
    limit = len(init_name)
    anagram_phrase = []
    remaining = init_name
    running = True
    while running:
        if len(remaining)<=limit:

            find_contained_anagrams(word_file, remaining)
            choice, remaining = process_choice(remaining)
            anagram_phrase.append(choice)
            print("\nRemaining letters: {}.".format("".join(remaining)))
            print("\nAnagram phrase: {}.".format(" ".join(anagram_phrase)))
        if len(remaining) == 0:
            print("\n*******FINISHED!*********\n")
            print("Anagram of name =", end=" ")
            print(" ".join(anagram_phrase))

            try_again = input("\n\nTry again? (Press Enter else 'n' to quit)\n")
            if try_again.lower() == "n":
                running = False
                sys.exit()
            else:
                main()


if __name__ == "__main__":
    main()
