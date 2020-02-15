"""Generate funny names by randomly combining names from two separate lists."""
import random
import sys

def main():
    """Choose two funny names at random and print to screen."""
    print("\n")
    print("Welcome to the Psych 'Sidekick Name Pickr.'\n")
    print("A name just like Sean would pick for Gus:\n")


    first = ('Sexy Pants', 'Panda Baby', 'Fluffball',
             'Tiktok', 'Wind of the West', 'Scut', 'Sneezy', 'Sleepy',
             'Lavendar')
    last = ('Bigmeat', 'Clover', 'Drackool', 'Frinkybeans',
            'Celery', 'Hadoop-y Poopy', 'Wyatt-E', 'Jimmy John')

    while True:

        first_name = random.choice(first)
        last_name = random.choice(last)

        print("{} {}".format(first_name, last_name), file=sys.stderr)


        try_again = input("\nTry again? (Press Enter else n to quit)\n")
        if try_again.lower() == "n":
            break

    input("\nPress Enter to exit.")

if __name__ == "__main__":
    main()
