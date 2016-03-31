﻿package bill;

public class make_bill {
	String plan;
	int line;
	int usage;
	int index_of_plan;
	
	public make_bill(){
		this.plan = null;
		this.line = 0;
		this.usage = 0;
		this.index_of_plan = 0;
	}
	public make_bill(String plan, int line, int usage){
		this.plan = plan;
		this.line = line;
		this.usage = usage;
		plan_to_int(this.plan);
	}
	
	
	/*
	 * 기본요금 리턴
	 */
	public double get_basicbill(){
		switch(index_of_plan){
		case 1:
			return 49.95;
		case 2:
			return 29.95;
		}
		return 0;
	}
	/*
	 * 회선별 추가요금 리턴
	 */
	public double get_linebill(){
		 if(line>3){
	            return planinfo.get_additional_line_cost()*2+familiy_discount();
	         }else{
	            return planinfo.get_additional_line_cost()*(line-1);
	         }

	}
	/*
	 * 초과사용 요금 리턴
	 */
	public double get_overcharge_for_usage(){
		switch(index_of_plan){
		case 1:
			if(usage>1000){
				return (usage - 1000)*0.45;
			}
		case 2:
			if(usage>500){
				return (usage-500)*0.54;
			}
		}
		return 0;
	}
	/*
	 * 가족할인 리턴
	 */
	public double family_discount(){
		return (line-2)*5;
	}
	/*
	 * 총 금액 리턴
	 */
	public double total_bill(){
		return get_basicbill()+get_linebill()+get_overcharge_for_usage();
	}
}
