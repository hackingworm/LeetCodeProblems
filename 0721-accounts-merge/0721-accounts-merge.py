class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        for i in range(len(accounts) - 1, -1, -1):
            merged = False
            emailsA = set(accounts[i][1:])
            for j in range(i - 1, -1, -1):
                emailsB = set(accounts[j][1:])
                if accounts[i][0] == accounts[j][0] and not emailsA.isdisjoint(emailsB):
                    accounts[j][1:] = list(emailsB.union(emailsA))
                    merged = True
                    break

            if merged:
                del accounts[i]
            else:
                accounts[i][1:] = list(emailsA)

        for i in range(len(accounts)):
            accounts[i][1:] = sorted(accounts[i][1:])

        return accounts

        '''
        for i in range(len(accounts)):
            current = accounts[i]
            for j in range(0, i):
                account = accounts[j]
                if current[0] == account[0] and not set(current[1:]).isdisjoint(account[1:]):
                    current.extend(account[1:])
                    account[0] = None

            noDuplicated = list(set(current[1:]))
            noDuplicated.sort()
            noDuplicated.insert(0, current[0])
            accounts[i] = noDuplicated

        sortedAccts = []
        for account in accounts:
            if None != account[0]:
                sortedAccts.append(account)

        return sortedAccts
        '''