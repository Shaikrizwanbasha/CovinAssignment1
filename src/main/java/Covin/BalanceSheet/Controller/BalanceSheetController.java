package Covin.BalanceSheet.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Covin.BalanceSheet.Service.BalanceSheetService;
import Covin.UserEntity.Userentity;

@RestController
@RequestMapping("/api/balance-sheet")
public class BalanceSheetController {
		
		@Autowired
	    private BalanceSheetService balanceSheetService;

	    @GetMapping
	    public ResponseEntity<Map<Userentity, Double>> getBalanceSheet() {
	        Map<Userentity, Double> balanceSheet = balanceSheetService.generateBalanceSheet();
	        return ResponseEntity.ok(balanceSheet);
	    }
	}


