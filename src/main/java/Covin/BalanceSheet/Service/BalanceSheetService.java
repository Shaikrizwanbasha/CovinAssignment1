package Covin.BalanceSheet.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Covin.ExpenseManagement.Entity.ExpenseManagement;
import Covin.ExpenseManagement.Entity.Split;
import Covin.ExpenseManagement.ServiceImpl.ExpenseManagementServiceImpl;
import Covin.UserEntity.Userentity;
import Covin.UserManagement.Serviceimple.Userservicesimpl;
@Service
public class BalanceSheetService {

	    @Autowired
	    private ExpenseManagementServiceImpl expenseService;

	    @Autowired
	    private Userservicesimpl userService;

	    public Map<Userentity, Double> generateBalanceSheet() {
	        Map<Long, Double> userBalances = new HashMap<>();
	        List<ExpenseManagement> allExpenses = expenseService.getAllExpenses();

	        for (ExpenseManagement expense : allExpenses) {
	            for (Split split : expense.getSplits()) {
	                userBalances.put(split.getUserId(), userBalances.getOrDefault(split.getUserId(), 0.0) + split.getAmount());
	            }
	        }

	        Map<Userentity, Double> balanceSheet = new HashMap<>();
	        for (Map.Entry<Long, Double> entry : userBalances.entrySet()) {
	            userService.getUserbyid(entry.getKey()).
	            ifPresent(user -> balanceSheet.put(user, entry.getValue()));
	        }

	        return balanceSheet;
	    }
	}

