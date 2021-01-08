note
	description: "Singleton access to the default business model."
	author: "Jackie Wang"
	date: "$Date$"
	revision: "$Revision$"

expanded class
	SPACE_DEFENDER_ACCESS

feature
	m: SPACE_DEFENDER
		once
			create Result.make
		end

invariant
	m = m
end




