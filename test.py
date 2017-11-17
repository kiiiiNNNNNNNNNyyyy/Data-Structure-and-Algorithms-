import pytest
from datetime import datetime
import numpy as np
import pandas as pd

# Your task is to write the group adjustment method below. There are multiple
# unit tests below, your job is to make sure they all pass. Feel free
# to add more tests.
# Your solution can be pure python, pure NumPy, pure Pandas
# or any combination of the three.  There are multiple ways of solving this
# problem, be creative, use comments to explain your code.  

# Group Adjust Method
# The algorithm needs to do the following:
# 1.) For each group-list provided, calculate the means of the values for each
# unique group.
#
#   For example:
#   vals       = [  1  ,   2  ,   3  ]
#   ctry_grp   = ['USA', 'USA', 'USA']
#   state_grp  = ['MA' , 'MA' ,  'CT' ]
#
#   There is only 1 country in the ctry_grp list.  So to get the means:
#     USA_mean == mean(vals) == 2
#     ctry_means = [2, 2, 2]
#   There are 2 states, so to get the means for each state:
#     MA_mean == mean(vals[0], vals[1]) == 1.5
#     CT_mean == mean(vals[2]) == 3
#     state_means = [1.5, 1.5, 3]
#
# 2.) Using the weights, calculate a weighted average of those group means
#   Continuing from our example:
#   weights = [.35, .65]
#   35% weighted on country, 65% weighted on state
#   ctry_means  = [2  , 2  , 2]
#   state_means = [1.5, 1.5, 3]
#   weighted_means = [2*.35 + .65*1.5, 2*.35 + .65*1.5, 2*.35 + .65*3]
#
# 3.) Subtract the weighted average group means from each original value
#   Continuing from our example:
#   val[0] = 1
#   ctry[0] = 'USA' --> 'USA' mean == 2, ctry weight = .35
#   state[0] = 'MA' --> 'MA'  mean == 1.5, state weight = .65
#   weighted_mean = 2*.35 + .65*1.5 = 1.675
#   demeaned = 1 - 1.675 = -0.675
#   Do this for all values in the original list.
#
# 4.) Return the demeaned values

# Hint: See the test cases below for how the calculation should work.


def group_adjust(vals, groups, weights):
	"""
	Calculate a group adjustment (demean).

	Parameters
	----------

	vals    : List of floats/ints

		The original values to adjust

	groups  : List of Lists

		A list of groups. Each group will be a list of ints

	weights : List of floats

		A list of weights for the groupings.

	Returns
	-------

	A list-like demeaned version of the input values
	"""
	
	# to get how many lists are there in groups
	no_of_groups= [isinstance(i, list) for i in groups].count(True)

	# ValueError if no of groups didn't match with weights length
	if no_of_groups != len(weights):
		#return "No of groups not matched with weights length"
		raise ValueError

	# Check if 
	for group in groups:
		if len(group) != len(vals):
			#return "Length of group does not matched with values length"
			raise ValueError

	# Logical Block for 2 groups
	if no_of_groups == 2:
		# dividing groups list into sublists
		ctry_grp, state_grp = groups

		# creating d1 pandas dataframe using sublists generated
		d1 = pd.DataFrame({'vals':vals, 'country':ctry_grp, 'state':state_grp})
		
		dc = pd.np.array(d1.groupby('country')['vals'].mean()[ctry_grp])*weights[0]
		ds = pd.np.array(d1.groupby('state')['vals'].mean()[state_grp])*weights[1]

		return pd.np.array(vals) - dc - ds

	elif no_of_groups == 3:
		ctry_grp, state_grp, city_grp = groups
		d1 = pd.DataFrame({'vals':vals, 'country':ctry_grp, 'state':state_grp, 'city':city_grp})
		
		start_2 = datetime.now()
		c_s = pd.np.array(d1.groupby('country')['vals'].mean()[ctry_grp]) * weights[0]

		s_s = pd.np.array(d1.groupby('state')['vals'].mean()[state_grp]) * weights[1]

		city_s = pd.np.array(d1.groupby('city')['vals'].mean()[city_grp]) * weights[2]
		end_2 = datetime.now()
		print (end_2 - start_2).total_seconds()

		return pd.np.array(vals) - c_s - s_s - city_s

def test_three_groups():
	vals = [1, 2, 3, 8, 5]
	grps_1 = ['USA', 'USA', 'USA', 'USA', 'USA']
	grps_2 = ['MA', 'MA', 'MA', 'RI', 'RI']
	grps_3 = ['WEYMOUTH', 'BOSTON', 'BOSTON', 'PROVIDENCE', 'PROVIDENCE']
	weights = [.15, .35, .5]

	adj_vals = group_adjust(vals, [grps_1, grps_2, grps_3], weights)
	answer = [-0.770, -0.520, 0.480, 1.905, -1.095]
	for ans, res in zip(answer, adj_vals):
		assert abs(ans - res) < 1e-5

def test_two_groups():
	vals = [1, 2, 3, 8, 5]
	grps_1 = ['USA', 'USA', 'USA', 'USA', 'USA']
	grps_2 = ['MA', 'RI', 'CT', 'CT', 'CT']
	weights = [.65, .35]

	adj_vals = group_adjust(vals, [grps_1, grps_2], weights)

	answer = [-1.81999, -1.16999, -1.33666, 3.66333, 0.66333]
	for ans, res in zip(answer, adj_vals):
		assert abs(ans - res) < 1e-5

def test_missing_vals():

	vals = [1, np.NaN, 3, 5, 8, 7]
	grps_1 = ['USA', 'USA', 'USA', 'USA', 'USA', 'USA']
	grps_2 = ['MA', 'RI', 'RI', 'CT', 'CT', 'CT']
	weights = [.65, .35]

	adj_vals = group_adjust(vals, [grps_1, grps_2], weights)

	answer = [-2.47, np.NaN, -1.170, -0.4533333, 2.54666666, 1.54666666]

	for ans, res in zip(answer, adj_vals):
		if ans is None:
			assert res is None
		elif np.isnan(ans):
			assert np.isnan(res)
		else:
			assert abs(ans - res) < 1e-5


def test_weights_len_equals_group_len():
	vals = [1, None, 3, 5, 8, 7]
	grps_1 = ['USA', 'USA', 'USA', 'USA', 'USA', 'USA']
	grps_2 = ['MA', 'RI', 'RI', 'CT', 'CT', 'CT']
	weights = [.65]

	with pytest.raises(ValueError):
		group_adjust(vals, [grps_1, grps_2], weights)


def test_group_len_equals_vals_len():
	vals = [1, None, 3, 5, 8, 7]
	grps_1 = ['USA']
	grps_2 = ['MA', 'RI', 'RI', 'CT', 'CT', 'CT']
	weights = [.65]

	with pytest.raises(ValueError):
		group_adjust(vals, [grps_1, grps_2], weights)


def test_performance():
	vals = 1000000 * [1, np.NaN, 3, 5, 8, 7]
	grps_1 = 1000000 * [1, 1, 1, 1, 1, 1]
	grps_2 = 1000000 * [1, 1, 1, 1, 2, 2]
	grps_3 = 1000000 * [1, 2, 2, 3, 4, 5]
	weights = [.20, .30, .50]

	start = datetime.now()
	group_adjust(vals, [grps_1, grps_2, grps_3], weights)
	end = datetime.now()
	diff = end - start
	print ('Total performance test time: {}'.format(diff.total_seconds()))

if __name__ == '__main__':
	
	print ("Running")
	# test_three_groups()
	# print "test_three_groups passed.."
	# test_two_groups()
	# print "test_two_groups passed.."
	# test_missing_vals()
	# print "test_missing_vals passed.."
	# test_weights_len_equals_group_len()
	# print "test_weights_len_equals_group_len passed.."
	# test_group_len_equals_vals_len()
	# print "test_group_len_equals_vals_len passed.."
	test_performance()
	# print "test_performance completed