import load_words

word_list = load_words.load("words.txt")
palindrome_list = []

def is_palindrome(word):
    if len(word)<=1:
        return True
    elif word[0] == word[-1]:
        return is_palindrome(word[1:-1])
    else:
        return False

for word in word_list:
    if len(word) > 1 and is_palindrome(word):
        palindrome_list.append(word)

print("\nNumber of palindromes found = {}\n".format(len(palindrome_list)))
print(*palindrome_list, sep='\n')
