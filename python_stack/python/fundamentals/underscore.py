class Underscore:
    def map(self, iterable, callback):
        for i, item in enumerate(iterable):
            iterable[i] = callback(item)
        return iterable
    def find(self, iterable, callback):
        for item in enumerate(iterable):
            if callback(item):
                return iterable
        return False
    def filter(self, iterable, callback):
        output = []
        for item in enumerate(iterable):
            if callback(item):
                output.append(item)
        return output        
    def reject(self, iterable, callback):
        output = []
        for item in enumerate(iterable):
            if not(callback(item)):
                output.append(item)
        return output        
