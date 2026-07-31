class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
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