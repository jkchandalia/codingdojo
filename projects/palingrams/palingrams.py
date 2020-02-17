import load_words
import time

word_list = load_words.load("words.txt")[0:20000]

def reverse_word(word):
    return word[::-1]

def is_palindrome(word):
    if word == reverse_word(word):
        return True
    return False


def find_palingrams():
    palingram_phrase = []
    for word in word_list:
        l = len(word)
        for i in range(1,l+1):
            trial_word = word[:i]
            remainder = word[i:]
            if reverse_word(trial_word) in word_list and is_palindrome(remainder):
                palingram_phrase.append(word + ' '+reverse_word(trial_word))

            elif reverse_word(remainder) in word_list and is_palindrome(trial_word):
                palingram_phrase.append(reverse_word(remainder)+ ' '+ word)
    return palingram_phrase

start = time.time()
palingram_phrase = find_palingrams()
end = time.time()
print("\nNumber of palingram phrases is: {}".format(len(palingram_phrase)))
print(*palingram_phrase, sep="\n")
print("\nTime taken is {} seconds.".format(end-start))
        

